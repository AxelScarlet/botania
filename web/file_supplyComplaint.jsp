<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>File a Complaint</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .dashboard-card {
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            cursor: pointer;
        }

        .dashboard-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
        }

        .dashboard-icon {
            font-size: 3rem;
            color: #0d6efd;
            margin-bottom: 10px;
        }
    </style>
</head>
<body class="bg-light">
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top">
        <div class="container">
            <a class="navbar-brand" href="supplierHome.html">Supplier</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item"><a class="nav-link" href="supplier_profile.html">Profile</a></li>
                    <li class="nav-item"><a class="nav-link" href="logout.html">Logout</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container mt-5 pt-5">
        <h1 class="text-center text-primary">File a Complaint</h1>
        <p class="text-center text-muted">Report any issues or concerns you have encountered.</p>
    </div>

    <div class="container mt-4">
        <form action="FileComplaintServlet" method="POST">
            <div class="mb-3">
                <label for="complaintTitle" class="form-label">Complaint Title</label>
                <input type="text" class="form-control" id="complaintTitle" required>
            </div>
            <div class="mb-3">
                <label for="complaintDescription" class="form-label">Complaint Description</label>
                <textarea class="form-control" id="complaintDescription" rows="5" required></textarea>
            </div>
            <button type="submit" class="btn btn-primary">Submit Complaint</button>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
