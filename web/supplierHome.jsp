<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Supplier Dashboard</title>
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
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top">
        <div class="container">
            <a class="navbar-brand" href="supplierHome.jsp">Supplier</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item"><a class="nav-link" href="SupplierProfileServlet">Profile</a></li>
                    <li class="nav-item"><a class="nav-link" href="LogoutServlet">Logout</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Content -->
    <div class="container mt-5 pt-5">
        <h1 class="text-center text-primary">Welcome,<%= session.getAttribute("username") %></h1>
        <p class="text-center text-muted">Manage your supply activities efficiently.</p>
    </div>

    <!-- Quick Actions -->
    <div class="container mt-4">
        <div class="row g-4">
            <div class="col-lg-4 col-md-6">
                <div class="card dashboard-card border-0 shadow-sm text-center" onclick="location.href='view_supplyRequests.jsp'">
                    <div class="card-body">
                        <i class="fa fa-eye dashboard-icon"></i>
                        <h5 class="card-title">View Supply Requests</h5>
                        <p class="card-text text-muted">Check incoming supply requests.</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="card dashboard-card border-0 shadow-sm text-center" onclick="location.href='manage_supplyRequests.jsp'">
                    <div class="card-body">
                        <i class="fa fa-tasks dashboard-icon"></i>
                        <h5 class="card-title">Manage Accepted Requests</h5>
                        <p class="card-text text-muted">Oversee approved requests.</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="card dashboard-card border-0 shadow-sm text-center" onclick="location.href='file_supplyComplaint.jsp'">
                    <div class="card-body">
                        <i class="fa fa-exclamation-circle dashboard-icon"></i>
                        <h5 class="card-title">File a Complaint</h5>
                        <p class="card-text text-muted">Report any issues encountered.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</body>
</html>
