<template>
  <div class="subs">
    <div class="container mrgnbtm">
      <button @click='getSubmissions()' type="button" class="btn btn-warning">Show Submissions</button>
    </div>
    <SubmissionTable v-if="submissions.length > 0" :submissions="submissions"/>
  </div>
</template>

<script>
import SubmissionTable from "@/components/SubmissionTable";
import {getSubmissions} from "@/services/HwService";

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Submission",
  components: {
    SubmissionTable
  },

  data() {
    return {
      submissions: []
    }
  },

  methods: {

    getSubmissions() {
      const params = {
        isTeacher: true
      }

      getSubmissions(params).then(response => {
        this.submissions = response
      })
    }
  }
}
</script>

<style scoped>
input {
  margin-right: 4px;
}
</style>