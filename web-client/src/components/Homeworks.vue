<template>
  <div class="container">
    <h2>Homeworks</h2>
    <table class="table table-bordered">
      <thead>
      <tr>
        <th>№</th>
        <th>Title</th>
        <th>Description</th>
        <th>Start</th>
        <th>DeadLine</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="item in homeworks" :key="item.id">
        <td>{{ item.id }}</td>
        <td>{{ item.title }}</td>
        <td>{{ item.taskDescription }}</td>
        <td>{{ item.publicationTime }}</td>
        <td>{{ item.deadline }}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: 'Homeworks',
  props: ['homeworks']
}
</script>