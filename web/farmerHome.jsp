<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Farmer Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Card Hover Effect */
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

    <!-- Content -->
    <div class="container mt-5 pt-5">
        <h1 class="text-center text-success">Welcome, <%= session.getAttribute("username") %> </h1>
        <p class="text-center text-muted">Manage your farming activities and requests with ease.</p>
    </div>

    <!-- Quick Actions (Cards) -->
    <div class="container mt-4">
        <div class="row g-4">
            <div class="col-lg-4 col-md-6">
                <div class="card dashboard-card border-0 shadow-sm text-center" onclick="location.href='farming_tips.jsp'">
                    <div class="card-body">
                        <i class="fa fa-leaf dashboard-icon"></i>
                        <h5 class="card-title">View Farming Tips</h5>
                        <p class="card-text text-muted">Get helpful tips for farming success.</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="card dashboard-card border-0 shadow-sm text-center" onclick="location.href='view_farmerRequests.jsp'">
                    <div class="card-body">
                        <i class="fa fa-eye dashboard-icon"></i>
                        <h5 class="card-title">View Farming Requests</h5>
                        <p class="card-text text-muted">Check incoming farming requests.</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="card dashboard-card border-0 shadow-sm text-center" onclick="location.href='manage_farmerRequests.jsp'">
                    <div class="card-body">
                        <i class="fa fa-tasks dashboard-icon"></i>
                        <h5 class="card-title">Manage Accepted Requests</h5>
                        <p class="card-text text-muted">Oversee and manage approved requests.</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="card dashboard-card border-0 shadow-sm text-center" onclick="location.href='request_farmingSupply.jsp'">
                    <div class="card-body">
                        <i class="fa fa-leaf dashboard-icon"></i>
                        <h5 class="card-title">Request Farming Supply</h5>
                        <p class="card-text text-muted">Request supply from supplier.</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="card dashboard-card border-0 shadow-sm text-center" onclick="location.href='file_farmerComplaint.jsp'">
                    <div class="card-body">
                        <i class="fa fa-exclamation-circle dashboard-icon"></i>
                        <h5 class="card-title">File a Complaint</h5>
                        <p class="card-text text-muted">Report any issues you encounter.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</body>
</html>