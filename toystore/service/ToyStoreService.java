package com.example.toystore.toystore.service;

import com.example.toystore.toystore.model.OrderDetails;
// import com.example.toystore.toystore.model.OrderDetails;
import com.example.toystore.toystore.model.Toy;
import com.example.toystore.toystore.model.ToyStore;
import com.example.toystore.toystore.repository.ToyStoreRepository;

// import org.springdoc.core.converters.models.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.toystore.toystore.repository.OrderDetailsRepository;
import com.example.toystore.toystore.repository.ToyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ToyStoreService {

    @Autowired
    private ToyStoreRepository toyStoreRepository;

    @Autowired
    private ToyRepository toyRepository;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    public List<ToyStore> getAllToyStores() {
        return toyStoreRepository.findAll();
    }

    public ToyStore getToyStoreById(Long id) {
        Optional<ToyStore> toyStoreOptional = toyStoreRepository.findById(id);
        return toyStoreOptional.orElse(null);
    }

    public ToyStore createToyStore(ToyStore toyStore) {
        return toyStoreRepository.save(toyStore);
    }
    public Toy createToy(Toy toy) {
        return toyRepository.save(toy);
    }
    public OrderDetails createOrder(OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);
    }

    public ToyStore updateToyStore(Long id, ToyStore toyStore) {
        toyStore.setId(id); // Ensure the ID is set
        return toyStoreRepository.save(toyStore);
    }

    public void deleteToyStore(Long id) {
        toyStoreRepository.deleteById(id);
    }

    public ToyStore getUserById1(Long userId) throws NotFoundException {
        Optional<ToyStore> userOptional = toyStoreRepository.findById(userId);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            // Handle the case when the user with the given ID is not found
            throw new NotFoundException();
        }
    }

    public List<ToyStore> getchild(String field) {
        Sort sort = Sort.by(Sort.Direction.ASC,field);
        return toyStoreRepository.findAll(sort);
    }

    public List<ToyStore> gettchild(int offset, int pagesize) {
        Pageable page = PageRequest.of(offset,pagesize);
        return toyStoreRepository.findAll(page).getContent();
    }

    public List<ToyStore> getttchild(int offset, int pagesize, String field) {
        return toyStoreRepository.findAll(PageRequest.of(offset,pagesize).withSort(Sort.by(Sort.Direction.ASC,field))).getContent();
    }
}
