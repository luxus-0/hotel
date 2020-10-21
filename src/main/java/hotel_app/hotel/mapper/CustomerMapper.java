package hotel_app.hotel.mapper;

import hotel_app.hotel.dto.CustomerDTO;
import hotel_app.hotel.entity.Customer;

public interface CustomerMapper {

    Customer toCustomer(CustomerDTO customerDTO);
    CustomerDTO toCustomerDTO(Customer customer);




}
