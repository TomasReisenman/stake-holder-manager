package tomas.reisenman.practice.service;

import tomas.reisenman.practice.exceptions.StakeHolderNotFoundException;
import tomas.reisenman.practice.model.Client;
import tomas.reisenman.practice.repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ClientService {

    private ClientRepo clientRepo;

    @Autowired
    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public List<Client> findAll(){
        return clientRepo.findAll();
    }

    public Client findById(final Long id){
        return clientRepo
                .findById(id)
                .orElseThrow(() -> new StakeHolderNotFoundException("No client with id: " + id ));
    }

    public Client updateClient(final Long id, final Map<String ,String > client){

        Client foundClient = findById(id);

        foundClient.setContactEmail(client.getOrDefault("contactEmail",foundClient.getContactEmail()));
        foundClient.setAddress(client.getOrDefault("address",foundClient.getAddress()));
        foundClient.setIndustry(client.getOrDefault("industry",foundClient.getIndustry()));

        ValidationService.validateConstraints(foundClient);

        return clientRepo.save(foundClient);
    }

    public void deleteById(final Long id){
         clientRepo.deleteById(id);
    }

    public Client saveClient(final Client client){

        ValidationService.validateConstraints(client);

        return clientRepo.save(client);
    }




}
