package hotel_app.hotel.mapper;

import hotel_app.hotel.dto.AddressDTO;
import hotel_app.hotel.entity.Address;
import org.modelmapper.ModelMapper;

public class AdressMapperImpl implements AddressMapper {

    public Address toAdress(AddressDTO addressDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Address address = modelMapper.map(addressDTO,Address.class);
        address.setPostalCode(addressDTO.getPostalCode());
        address.setStreet(addressDTO.getStreet());
        address.setCity(addressDTO.getCity());


        return address;
    }

    public AddressDTO toAdressDTO(Address address) {
        ModelMapper modelMapper = new ModelMapper();
        AddressDTO addressDTO = modelMapper.map(address,AddressDTO.class);
        addressDTO.setPostalCode(address.getPostalCode());
        addressDTO.setStreet(address.getStreet());
        addressDTO.setCity(address.getCity());


        return addressDTO;
    }
}
