<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Farming Requests</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .table th, .table td {
            vertical-align: middle;
            text-align: center;
        }

        .navbar-brand {
            font-weight: bold;
        }
    </style>
</head>
<body class="bg-light">
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-success fixed-top">
        <div class="container">
            <a class="navbar-brand" href="farmerHome.jsp">Farmer</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item"><a class="nav-link" href="FarmerProfileServlet">Profile</a></li>
                    <li class="nav-item"><a class="nav-link" href="LogoutServlet">Logout</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Page Content -->
    <div class="container mt-5 pt-5">
        <h1 class="text-center text-dark">Farming Requests</h1>
        <p class="text-center text-muted">Manage farming-related requests and create new ones.</p>
        <div class="text-center">
            <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#createRequestModal">Create New Request</button>
        </div>
    </div>

    <!-- Requests Table -->
    <div class="container mt-4">
        <div class="table-responsive">
            <table class="table table-bordered table-striped align-middle" id="requestsTable">
                <thead class="table-primary">
                    <tr>
                        <th>Request No</th>
                        <th>Request Title</th>
                        <th>Request Description</th>
                        <th>Taken By</th>
                        <th>Phone Number</th>
                        <th>Status</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Rows will be dynamically added here -->
                </tbody>
            </table>
        </div>
    </div>

    <!-- Modal for Creating New Request -->
    <div class="modal fade" id="createRequestModal" tabindex="-1" aria-labelledby="createRequestModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="createRequestModalLabel">Create New Request</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <form id="requestForm">
                    <div class="modal-body">
                        <div class="mb-3">
                            <label for="requestTitle" class="form-label">Request Title</label>
                            <input type="text" class="form-control" id="requestTitle" required>
                        </div>
                        <div class="mb-3">
                            <label for="requestDate" class="form-label">When Needed</label>
                            <input type="date" class="form-control" id="requestDate" required>
                        </div>
                        <div class="mb-3">
                            <label for="requestDescription" class="form-label">Request Description</label>
                            <textarea class="form-control" id="requestDescription" rows="3" required></textarea>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                        <button type="submit" class="btn btn-primary">Submit Request</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- JavaScript -->
    <script>
        let requestCounter = 1; // Auto-increment Request No.
        const requestForm = document.getElementById('requestForm');
        const requestsTable = document.getElementById('requestsTable').querySelector('tbody');

        // Handle form submission
        requestForm.addEventListener('submit', function(event) {
            event.preventDefault();

            // Get form values
            const title = document.getElementById('requestTitle').value;
            const description = document.getElementById('requestDescription').value;
            const date = document.getElementById('requestDate').value;

            // Add new row to the table
            const newRow = `
                <tr>
                    <td>${requestCounter}</td>
                    <td>${title}</td>
                    <td>${description} (Needed by: ${date})</td>
                    <td>-</td>
                    <td>-</td>
                    <td><span class="badge bg-warning text-dark">Pending</span></td>
                    <td>
                        <button class="btn btn-secondary btn-sm">Update</button>
                        <button class="btn btn-danger btn-sm">Delete</button>
                    </td>
                </tr>
            `;
            requestsTable.insertAdjacentHTML('beforeend', newRow);

            // Increment request counter and reset form
            requestCounter++;
            requestForm.reset();

            // Close the modal
            const modal = bootstrap.Modal.getInstance(document.getElementById('createRequestModal'));
            modal.hide();
        });
    </script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
