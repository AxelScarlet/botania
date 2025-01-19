<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
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
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
        <div class="container">
            <a class="navbar-brand" href="adminHome.jsp">Admin</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item"><a class="nav-link" href="logout.jsp">Logout</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Content -->
    <div class="container mt-5 pt-5">
        <h1 class="text-center text-dark">Admin Dashboard</h1>
        <p class="text-center text-muted">Manage all activities and monitor requests efficiently.</p>
    </div>

    <!-- Quick Actions (Cards) -->
    <div class="container mt-4">
        <div class="row g-4">
            <div class="col-lg-4 col-md-6">
                <div class="card dashboard-card border-0 shadow-sm text-center" onclick="location.href='manage_users.html'">
                    <div class="card-body">
                        <i class="fa fa-users dashboard-icon"></i>
                        <h5 class="card-title">Manage Users</h5>
                        <p class="card-text text-muted">Manage admin, farmer and supplier accounts.</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="card dashboard-card border-0 shadow-sm text-center" onclick="location.href='view_complaints.html'">
                    <div class="card-body">
                        <i class="fa fa-exclamation-triangle dashboard-icon"></i>
                        <h5 class="card-title">View Complaints</h5>
                        <p class="card-text text-muted">Monitor complaints submitted by users.</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="card dashboard-card border-0 shadow-sm text-center" onclick="location.href='farming_requests.html'">
                    <div class="card-body">
                        <i class="fa fa-seedling dashboard-icon"></i>
                        <h5 class="card-title">Farming Requests</h5>
                        <p class="card-text text-muted">Manage farming-related requests.</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="card dashboard-card border-0 shadow-sm text-center" onclick="location.href='manage_tips.html'">
                    <div class="card-body">
                        <i class="fa fa-exclamation-circle dashboard-icon"></i>
                        <h5 class="card-title">Manage Farming Tips</h5>
                        <p class="card-text text-muted">Give helpful tips for farming success.</p>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</body>
</html>
