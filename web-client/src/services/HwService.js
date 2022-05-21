const axios = require('axios');

export async function getHomeworks() {
    // const currentDate = new Date();
    const response = await axios.get("/api/hw/all", {
        params: {
            date: "2022-01-01T00:00:00"
        }
    })
    return response.data
}

export async function submitHomeworkSolution(submission) {
    const response = await axios.post("/api/submit", {hwSubmission: submission});
    return response.data;
}

export async function getSubmissions(user) {
    const response = await axios.get("/api/hw/submissions", { params: {user: user} })
    return response.data
}

export async function addHomework(homework) {
    await axios.post("/api/add", {homework: homework});
}

export async function evaluateSubmission(mark, comment, submissionId) {
    const response = await axios.patch("/api/sub_id=" + submissionId.toString(), {mark: mark, comment: comment})
    return response.data;
}
