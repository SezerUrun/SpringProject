package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class EntryService {

    private EntryRepository entryRepository;

    public EntryService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public List<Entry> getEntries() {
        return entryRepository.findAll();
    }

    public Entry saveEntry(Entry entry) {
        return entryRepository.save(entry);
    }

    public List<Entry> removeAll(){
       entryRepository.deleteAll();
       return entryRepository.findAll();
    }

    public List<Entry> removeEntry(long id){
        entryRepository.deleteById(id);
        return entryRepository.findAll();
    }

}