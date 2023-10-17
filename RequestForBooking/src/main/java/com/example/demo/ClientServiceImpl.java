package com.example.demo;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
public class ClientServiceImpl implements ClientServices {
	
	@Autowired 
	private ClientRepository empRepo;
	
 
    @Override public void save(Client client)
    {
        empRepo.save(client);
    }
 
    @Override public Client getById(Long id)
    {
        Optional<Client> optional = empRepo.findById(id);
        Client client = null;
        if (optional.isPresent())
            client = optional.get();
        else
            throw new RuntimeException(
                "Client not found for id : " + id);
        return client;
    }
 
    @Override public void deleteViaId(long id)
    {
        empRepo.deleteById(id);
    }
    
    @Override
	public Page<Client> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.empRepo.findAll(pageable);
	}


	@Override
	public List<Client> getAllClient() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}



}