package customer.domain;

import java.util.Collection;

public record CustomersList(Collection<CustomerRow> customers) {
}
