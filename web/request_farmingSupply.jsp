<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Request Supply from Supplier</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Modal Content Customization */
        .modal-header {
            background-color: #28a745;
            color: white;
        }
    </style>
</head>
<body class="bg-light">
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-success fixed-top">
        <div class="container">
            <a class="navbar-brand" href="farmerHome.html">Farmer</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item"><a class="nav-link" href="farmer_profile.html">Profile</a></li>
                    <li class="nav-item"><a class="nav-link" href="logout.html">Logout</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Page Content -->
    <div class="container mt-5 pt-5">
        <h1 class="text-center text-success">Request Supply from Supplier</h1>
        <p class="text-center text-muted">View requests and submit your own supply request to a supplier.</p>

        <!-- Button to trigger modal -->
        <div class="text-center mb-4">
            <button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#requestModal">Request New Supply</button>
        </div>

        <!-- Table of Requests -->
        <div class="table-responsive">
            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>Supply Title</th>
                        <th>Supply Description</th>
                        <th>Supplier</th>
                        <th>Supplier Phone</th>
                        <th>Arrival Date</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Example Table Row -->
                    <tr>
                        <td>Fertilizer</td>
                        <td>Organic fertilizer for crops</td>
                        <td>John Supplier</td>
                        <td>+1234567890</td>
                        <td>2024-12-05</td>
                    </tr>
                    <tr>
                        <td>Seeds</td>
                        <td>High-quality seeds for vegetables</td>
                        <td>Jane Supplier</td>
                        <td>+0987654321</td>
                        <td>2024-12-06</td>
                    </tr>
                    <!-- Add more rows dynamically as needed -->
                </tbody>
            </table>
        </div>
    </div>

    <!-- Modal for Requesting Supply -->
    <div class="modal fade" id="requestModal" tabindex="-1" aria-labelledby="requestModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="requestModalLabel">Request New Supply</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form id="requestForm">
                        <div class="mb-3">
                            <label for="supplyTitle" class="form-label">Supply Title</label>
                            <input type="text" class="form-control" id="supplyTitle" name="supplyTitle" required>
                        </div>
                        <div class="mb-3">
                            <label for="supplyDescription" class="form-label">Supply Description</label>
                            <textarea class="form-control" id="supplyDescription" name="supplyDescription" rows="3" required></textarea>
                        </div>
                        <div class="mb-3">
                            <label for="whenNeeded" class="form-label">When Needed</label>
                            <input type="date" class="form-control" id="whenNeeded" name="whenNeeded" required>
                        </div>
                        <div class="mb-3">
                            <label for="supplier" class="form-label">Choose Supplier</label>
                            <select class="form-select" id="supplier" name="supplier" required>
                                <option value="John Supplier">John Supplier</option>
                                <option value="Jane Supplier">Jane Supplier</option>
                                <!-- Add more suppliers as needed -->
                            </select>
                        </div>
                        <div class="d-grid">
                            <button type="submit" class="btn btn-success">Submit Request</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- JavaScript for Modal -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
