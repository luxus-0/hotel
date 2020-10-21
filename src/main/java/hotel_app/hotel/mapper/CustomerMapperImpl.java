package hotel_app.hotel.mapper;

import hotel_app.hotel.dto.CustomerDTO;
import hotel_app.hotel.entity.Customer;
import org.modelmapper.ModelMapper;

public class CustomerMapperImpl implements CustomerMapper {

    public Customer toCustomer(CustomerDTO customerDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Customer customer = modelMapper.map(customerDTO,Customer.class);
        customer.setName(customerDTO.getName());
        customer.setSurname(customerDTO.getSurname());
        customer.setGender(customerDTO.getGender());
        customer.setEmail(customerDTO.getEmail());


        return customer;
    }

    public CustomerDTO toCustomerDTO(Customer customer) {
        ModelMapper modelMapper = new ModelMapper();
        CustomerDTO customerDTO = modelMapper.map(customer,CustomerDTO.class);
        customerDTO.setName(customer.getName());
        customerDTO.setSurname(customer.getSurname());
        customerDTO.setGender(customer.getGender());
        customerDTO.setEmail(customer.getEmail());


        return customerDTO;
    }
}
