#!/usr/bin/env bash
# Run `make prod` first

# abort script if a command fails
set -e

find target/site -type d -name support -prune -o -type d -name reference -prune -o -type d -name _attachments -prune -o -type d -name services -prune -o -type d -name libraries -prune -o -name "404.html" -prune -o -name "*.adoc\[\].html" -prune -o \
  -type f -name "*.html" -exec sh -c 'npx -y d2m@latest -e -i {} -o {}.md ' \;

# replace numbered references in code snippets
if [[ "$OSTYPE" == "darwin"* ]]; then
  find target/site -type f -name "*.html.md" -print0 | xargs -0 sed -i '' -E 's/\(([0-9]+)\)/\/\/ (\1)/g'
else
  find target/site -type f -name "*.html.md" -print0 | xargs -0 sed -i -E 's/\(([0-9]+)\)/\/\/ (\1)/g'
fi

cp docs/src/modules/ROOT/pages/llms.txt target/site/

mkdir -p target/docs-md
rsync -av --prune-empty-dirs --include="*/" --include="*.html.md" --exclude="*" target/site/ target/docs-md/
(cd target/docs-md && zip -r ../../target/site/java/_attachments/akka-docs-md.zip .)

# update ask-akka-agent
#find target/site -name "index.html.md" -prune -o -type f -name "*.html.md" -exec cp {} samples/ask-akka-agent/src/main/resources/md-docs/ \;
