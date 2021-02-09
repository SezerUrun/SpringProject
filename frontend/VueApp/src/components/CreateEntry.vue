<template>
  <div class="container">
    <div class="row">
        <div class="col-md-7 mrgnbtm">
            <form>
                <div class="row">
                    <div class="form-group col-md-6">
                        <input type="text" class="form-control" v-model="data" name="data" id="data" aria-describedby="dataHelp" placeholder="data" />
                    </div>
                    <div class="form-group col-md-6">
                    <button type="button" @click='createEntry()' class="btn btn-danger">Create</button>
                    </div>
                </div>
                <div class="row">
                        <div class="form-group col-md-6">
                            <input type="text" class="form-control" v-model="id" name="id" id="id" aria-describedby="idHelp" placeholder="id" />
                        </div>
                        <div class="form-group col-md-6">
                            <button type="button" @click='removeEntry()' class="btn btn-danger">Remove</button>
                        </div>
                </div>
                <div class="row">
                    <button type="button" @click='removeAllEntries()' class="btn btn-danger">Remove All</button>
                </div>
            </form>
        </div>
    </div>
    </div>
</template>

<script>
export default {
  name: 'CreateEntry',
  data() {
    return {
      data: '',
    }
  },
  methods: {
      createEntry() {
          const payload = {
              data: this.data
          }
          this.$emit('createEntry', payload)
          this.clearForm();
      },
      clearForm() {
          this.id = "";
          this.data = "";
      },
        removeEntry(){
            const payload = {
                  id: this.id
              }
              this.$emit('removeEntry', payload)
              this.clearForm();
        },
        removeAllEntries(){
              this.$emit('removeAllEntries')
              this.clearForm();
        }
  }
}
</script>
