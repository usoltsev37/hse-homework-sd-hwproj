<template>
<div class="container">
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
    <td>{{ item.studentId }}</td>
    <td>{{ item.createdAt }}</td>
    <td>{{ item.solution }}</td>
    <td>{{ item.mark }}</td>
    <td>{{ item.comment }}</td>
    <td>{{ item.checkerVerdict }}</td>
  </tr>
  </tbody>
</table>
</div>
</template>

<script>
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: 'SubmissionsTable',
  props: ['submissions']
}
</script>