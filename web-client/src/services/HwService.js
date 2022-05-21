const axios = require('axios');
axios.create({
    headers: {
        "Content-type": "application/json"
    }
});

export async function getHomeworks() {
    const currentDate = new Date();
    const response = await axios.get("hw/all", {
        params: {
            date: currentDate.toISOString()
        }
    })
    return response.data
}

export async function submitHomeworkSolution(submission) {
    console.log(submission);
    const response = await axios.post("hw/submit", submission);
    return response.data;
}

export async function getSubmissions(user) {
    const response = await axios.get("hw/submissions", {
        params: user
    })
    return response.data
}

export async function addHomework(homework) {
    await axios.post("hw/add", homework);
}

export async function evaluateSubmission(mark, comment, submissionId) {
    const response = await axios.patch("hw/sub_id=" + submissionId.toString(), {mark: mark, comment: comment})
    return response.data;
}
