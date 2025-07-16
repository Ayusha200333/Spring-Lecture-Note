const API_BASE_URL = "http://localhost:8080/api/v1/job";
//
// // Load all jobs on page load
// $(document).ready(() => {
//     loadJobs();
// });


$('#saveJobBtn').click(() => {
    const job = {
        jobTitle: $('#jobTitle').val(),
        company: $('#companyName').val(),
        location: $('#jobLocation').val(),
        type: $('#jobType').val(),
        jobDescription: $('#jobDescription').val(),
        status: "Open"
    };

    console.log("Sending job:", job); // Debug line

    $.ajax({
        url: `${API_BASE_URL}/create`,
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(job),
        success: () => {
            loadJobs();
            $('#addJobForm')[0].reset();
        },
        error: (xhr) => {
            console.error("Error response:", xhr.responseText);
            alert("Error saving job!");
        }
    });
});

//
// // Load all jobs
// function loadJobs() {
//     $.ajax({
//         url: `${API_BASE_URL}/all`,
//         method: 'GET',
//         success: (data) => {
//             const tbody = $('#jobsTableBody');
//             tbody.empty();
//             data.forEach((job, index) => {
//                 tbody.append(`
//                     <tr>
//                         <td>${index + 1}</td>
//                         <td>${job.jobTitle}</td>
//                         <td>${job.company}</td>
//                         <td>${job.location}</td>
//                         <td>${job.type}</td>
//                         <td>${job.status}</td>
//                         <td>
//                             <button class="btn btn-sm btn-warning" onclick='showEditModal(${JSON.stringify(job)})'>Edit</button>
//                         </td>
//                     </tr>
//                 `);
//             });
//         }
//     });
// }
//
// // Show Edit Modal
// function showEditModal(job) {
//     $('#editJobId').val(job.id);
//     $('#editJobTitle').val(job.jobTitle);
//     $('#editCompanyName').val(job.company);
//     $('#editJobLocation').val(job.location);
//     $('#editJobType').val(job.type);
//     $('#editJobDescription').val(job.jobDescription);
//     $('#editJobModal').modal('show');
// }
//
// // Update job
// $('#updateJobBtn').click(() => {
//     const updatedJob = {
//         id: $('#editJobId').val(),
//         jobTitle: $('#editJobTitle').val(),
//         company: $('#editCompanyName').val(),
//         location: $('#editJobLocation').val(),
//         type: $('#editJobType').val(),
//         jobDescription: $('#editJobDescription').val(),
//         status: "Open"
//     };
//
//     $.ajax({
//         url: `${API_BASE_URL}/update`,
//         method: 'PUT',
//         contentType: 'application/json',
//         data: JSON.stringify(updatedJob),
//         success: () => {
//             loadJobs();
//             $('#editJobForm')[0].reset();
//         },
//         error: () => alert("Update failed!")
//     });
// });
