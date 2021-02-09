<template>
  <div class="hello">
    <Header />
    <div class="container mrgnbtm">
          <div class="row">
            <div class="col-md-8">
                <CreateEntry @createEntry="entryCreate($event)" />
            </div>
            <div class="col-md-8">
                <RemoveEntry @removeEntry="remove($event)" />
            </div>
            <div class="col-md-8">
                <RemoveAll @removeAllEntries="removeAll($event)" />
            </div>

          </div>
    </div>
    <div class="row mrgnbtm">
        <Entries v-if="entries.length > 0" :entries="entries" />
    </div>
  </div>
</template>

<script>
import Header from './Header.vue'
import CreateEntry from './CreateEntry.vue'
import Entries from './Entries.vue'
import { getAllEntries, createEntry , removeEntry, removeAllEntries} from '../services/EntryService'

export default {
  name: 'Dashboard',
  components: {
    Header,
    CreateEntry,
    Entries
  },
  data() {
      return {
          entries: [],
          numberOfEntries: 0
      }
  },
  methods: {
    getAllEntries() {
      getAllEntries().then(response => {
        console.log(response)
        this.entries = response;
        this.numberOfEntries = this.entries.length;
      })
    },
    entryCreate(data) {
      console.log('data:::', data)
      data.id = this.numberOfEntries + 1
      createEntry(data).then(response => {
        console.log(response);
        this.getAllEntries();
      });
    },

    remove(id) {
      removeEntry(id).then(response => {
        console.log(response);
        this.getAllEntries();
      });
    },

    removeAll() {
      removeAllEntries().then(response => {
        console.log(response);
        this.entries=response;
        this.getAllEntries();
      });
    }
  },
  mounted () {
    this.getAllEntries();
  }
}
</script>
