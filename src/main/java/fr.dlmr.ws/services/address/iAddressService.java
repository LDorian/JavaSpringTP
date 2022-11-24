package fr.dlmr.ws.services.address;

import fr.dlmr.ws.models.dto.AddressDto;

public interface iAddressService {
    public boolean checkAddress(AddressDto address);
}
