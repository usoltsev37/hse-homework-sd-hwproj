<template>
  <div class="display-board">
    <h4>Submissions</h4>
    <div class="number">
      {{ numberOfSubmissions }}
    </div>
    <div class="btn">
      <button @click='getSubmissions({id: 0, name: "Jack", isTeacher: false})' type="button" class="btn btn-warning">Get
        Submissions
      </button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'SubmissionTable',
  props: ['numberOfSubmissions'],
  data() {
    return {
      id: '',
      name: '',
      isTeacher: ''
    }
  },
  methods: {
    getSubmissions(user) {
      this.$emit('getSubmissions', user)
    }
  }
}
</script>