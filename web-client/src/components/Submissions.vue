<template>
  <div class="container">
    <h2>Homeworks</h2>
    <table class="table table-bordered">
      <thead>
      <tr>
        <th>№_submission</th>
        <th>№_hw</th>
        <th>StudentId</th>
        <th>CreatedAt</th>
        <th>Solution</th>
        <th>Mark</th>
        <th>Comment</th>
        <th>CheckerVerdict</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="item in submissions" :key="item.id">
        <td>{{ item.id }}</td>
        <td>{{ item.hwId }}</td>
        <td>{{ item.StudentId }}</td>
        <td>{{ item.CreatedAt }}</td>
        <td>{{ item.Solution }}</td>
        <td>{{ item.Mark }}</td>
        <td>{{ item.Comment }}</td>
        <td>{{ item.CheckerVerdict }}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: 'Submissions',
  props: ['submissions']
}
</script>