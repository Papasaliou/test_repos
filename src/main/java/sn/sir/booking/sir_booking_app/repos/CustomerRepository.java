package sn.sir.booking.sir_booking_app.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.sir.booking.sir_booking_app.domain.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
