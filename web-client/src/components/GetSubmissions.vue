<template>
  <h1> ХУЙ </h1>
  <div class="container mrgnbtm">
    <div class="row">
      <div class="col-md-4">
        <SubmissionTable :number-of-submissions="numberOfSubmissions" @getSubmissions="getSubmissions()"/>
      </div>
    </div>
  </div>
  <div class="row mrgnbtm">
    <Submissions v-if="submissions.length > 0" :submissions="submissions"/>
  </div>
  <p></p>
</template>

<script>
import {getSubmissions} from "@/services/HwService";
import Submissions from "@/components/Submissions";
import SubmissionTable from "@/components/SubmissionTable";

export default {
  name: 'getSubmissions',
  components: {
    Submissions,
    SubmissionTable
  },

  data() {
    return {
      submissions: [],
      numberOfSubmissions: 0
    }
  },

  methods: {
    getSubmissions() {
      const payload = {
        id: 0,
        name: 'Jack',
        isTeacher: false
      }
      getSubmissions(payload).then(response => {
        this.submissions = response
      })
    }

  },

  mounted() {
    this.getSubmissions();
  }
}
</script>