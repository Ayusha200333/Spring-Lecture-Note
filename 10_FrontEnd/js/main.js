const API_BASE_URL = "http://localhost:8080/api/v1/job";

const editModal = new bootstrap.Modal(document.getElementById('editJobModal'));

let currentPage = 0;
const pageSize = 5;

$(document).ready(() => {
    loadJobs();

    $('#saveJobBtn').click(() => {
        const job = {
            jobTitle: $('#jobTitle').val(),
            company: $('#companyName').val(),
            location: $('#jobLocation').val(),
            type: $('#jobType').val(),
            jobDescription: $('#jobDescription').val(),
            status: "Active"
        };

        $.ajax({
            url: `${API_BASE_URL}/create`,
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(job),
            success: () => {
                clearAddJobForm();
                loadJobs(currentPage);
                bootstrap.Modal.getInstance(document.getElementById('addJobModal')).hide();
            },
            error: () => alert("Error saving job!")
        });
    });

    $('#updateJobBtn').click(() => {
        const id = $('#editJobId').val();
        const job = {
            id: id,
            jobTitle: $('#editJobTitle').val(),
            company: $('#editCompanyName').val(),
            location: $('#editJobLocation').val(),
            type: $('#editJobType').val(),
            jobDescription: $('#editJobDescription').val(),
            status: "Active"
        };

        $.ajax({
            url: `${API_BASE_URL}/update`,
            method: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(job),
            success: () => {
                loadJobs(currentPage);
                editModal.hide();
            },
            error: () => alert("Error updating job!")
        });
    });

    $('#searchInput').on('input', function () {
        const keyword = $(this).val().trim();
        if (keyword === '') {
            loadJobs();
        } else {
            searchJobs(keyword);
        }
    });

    $('#jobsTableBody').on('click', '.change-status-btn', function () {
        const id = $(this).data('id');
        $.ajax({
            url: `${API_BASE_URL}/status/${id}`,
            method: 'PATCH',
            success: () => loadJobs(currentPage),
            error: () => alert('Failed to change status.')
        });
    });

    $('#jobsTableBody').on('click', '.delete-btn', function () {
        const id = $(this).data('id');
        if (confirm('Are you sure you want to delete this job?')) {
            $.ajax({
                url: `${API_BASE_URL}/delete/${id}`,
                method: 'DELETE',
                success: () => loadJobs(currentPage),
                error: () => alert('Failed to delete job.')
            });
        }
    });

    $('#jobsTableBody').on('click', '.edit-btn', function () {
        const id = $(this).data('id');
        editJob(id);
    });
});


function loadJobs(page = 0) {
    $.ajax({
        url: `${API_BASE_URL}/jobs?page=${page}&size=${pageSize}`,
        method: "GET",
        success: function (response) {
            renderJobs(response.content, page); // pass page to rendering
            renderPagination(response.totalPages, page);
            currentPage = page;
        },
        error: function (xhr) {
            alert(`Failed to load jobs. ${xhr.status}: ${xhr.statusText}`);
        }
    });
}

function renderPagination(totalPages, currentPage) {
    const pagination = $('#pagination');
    pagination.empty();

    if (totalPages === 0) return;

    for (let i = 0; i < totalPages; i++) {
        const activeClass = i === currentPage ? 'active' : '';
        pagination.append(`
            <li class="page-item ${activeClass}">
                <a class="page-link" href="#">${i + 1}</a>
            </li>
        `);
    }

    $('.page-link').click(function (e) {
        e.preventDefault();
        const selectedPage = parseInt($(this).text()) - 1;
        loadJobs(selectedPage);
    });
}


function renderJobs(jobs, page) {
    const tbody = $('#jobsTableBody');
    tbody.empty();

    const startSerial = page * pageSize + 1;

    jobs.forEach((job, index) => {
        const row = `
            <tr>
                <td>${startSerial + index}</td>
                <td>${job.jobTitle ?? ''}</td>
                <td>${job.company ?? ''}</td>
                <td>${job.location ?? ''}</td>
                <td>${job.type ?? ''}</td>
                <td>${job.jobDescription ?? ''}</td>
                <td>
                    <button class="btn btn-sm ${job.status === 'Active' ? 'btn-success' : 'btn-secondary'} change-status-btn" data-id="${job.id}">
                        ${job.status}
                    </button>
                </td>
                <td>
                    <button class="btn btn-sm btn-warning me-1 edit-btn" data-id="${job.id}">Edit</button>
                    <button class="btn btn-sm btn-danger delete-btn" data-id="${job.id}">Delete</button>
                </td>
            </tr>`;
        tbody.append(row);
    });
}

function editJob(id) {
    $.ajax({
        url: `${API_BASE_URL}/get/${id}`,
        method: 'GET',
        success: function (job) {
            $('#editJobId').val(job.id);
            $('#editJobTitle').val(job.jobTitle);
            $('#editCompanyName').val(job.company);
            $('#editJobLocation').val(job.location);
            $('#editJobType').val(job.type);
            $('#editJobDescription').val(job.jobDescription);
            editModal.show();
        },
        error: () => alert('Failed to fetch job data.')
    });
}

function searchJobs(keyword) {
    $.ajax({
        url: `${API_BASE_URL}/search/${keyword}`,
        method: 'GET',
        success: function (jobs) {
            renderJobs(jobs, 0); // search mode – show as page 0
            $('#pagination').empty(); // hide pagination
        },
        error: () => alert('Failed to search jobs.')
    });
}

function clearAddJobForm() {
    $('#jobTitle').val('');
    $('#companyName').val('');
    $('#jobLocation').val('');
    $('#jobType').val('Full-time');
    $('#jobDescription').val('');
}


