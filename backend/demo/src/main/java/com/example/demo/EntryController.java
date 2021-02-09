package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EntryController {
    private int id=0;
    @Autowired
    EntryService entryService;

    ArrayList<Entry> arrayList_entries=new ArrayList<>();

    //@RequestMapping("/api/entries")
    @GetMapping("/api/entries")
    public ResponseEntity<?> getEntries() {
        //return arrayList_entries;
        List<Entry> resource = entryService.getEntries();
        return ResponseEntity.ok(resource);
    }

    @PostMapping("/api/entry")
    public ResponseEntity<?> createEntry(@RequestBody Entry entry) {
        Entry resource = entryService.saveEntry(entry);
        //return ResponseEntity.ok(resource);
        return ResponseEntity.ok(resource);
    }

    @RequestMapping("/api/entry/remove")
    public ResponseEntity<?> deleteEntry(@RequestParam(value = "id", defaultValue = "-1") long id) {
        entryService.removeEntry(id);
        List<Entry> resource = entryService.getEntries();
        return ResponseEntity.ok(resource);
    }

    @RequestMapping("/api/entries/remove")
    public ResponseEntity<?> deleteAllEntries() {
        entryService.removeAll();
        List<Entry> resource = entryService.getEntries();
        return ResponseEntity.ok(resource);
    }

    /*
    @PostMapping("/api/entry")
    public List<Entry> createEntry(@RequestParam(value = "data", defaultValue = "sample data") String data) {
        arrayList_entries.add(new Entry(data));
        return arrayList_entries;
    }

    @RequestMapping("/api/entry/update")
    public List<Entry> updateEntry(@RequestParam(value = "id", defaultValue = "-1") int id, @RequestParam(value = "data", defaultValue = ".") String data) {
        arrayList_entries.get(id).setData(data);
        return arrayList_entries;
    }

    @RequestMapping("/api/entry/remove")
    public List<Entry> deleteEntry(@RequestParam(value = "id", defaultValue = "-1") int id) {
        if(id>0) {
            arrayList_entries.remove(id);
        }
        return arrayList_entries;
    }

    @RequestMapping("/api/entries/remove")
    public List<Entry> deleteAllEntries() {
        arrayList_entries.clear();
        id=0;
        return arrayList_entries;
    }
    */
}
