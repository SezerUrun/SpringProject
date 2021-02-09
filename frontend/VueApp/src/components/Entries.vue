<template>
    <div class="container">
        <h2>Entries</h2>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Id</th>
                <th>Data</th>
            </tr>
            </thead>
            <tbody>
              <tr v-for="item in entries" :key="item.id">
                  <td>{{ item.id }}</td>
                  <td>{{ item.data }}</td>
              </tr>
            </tbody>
        </table>
    </div>
</template>

<script>

    export default {
        name: 'Entries',
        props: ['entries']
     }
</script>
