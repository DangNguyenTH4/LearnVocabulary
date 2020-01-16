package TestRepositoryMany;

import org.springframework.stereotype.Repository;

@Repository
public interface OrderReporsitory extends OrderRepositoryCustom, OrderRepositoryCustomer2 {

}
