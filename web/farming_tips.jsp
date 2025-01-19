<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Farming Tips</title>
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

    <div class="container mt-5 pt-5">
        <h1 class="text-center text-success">Farming Tips</h1>
        <p class="text-center text-muted">Get helpful tips for improving your farming activities and productivity.</p>
    </div>

    <div class="container mt-4">
        <div class="row g-4">
            <div class="col-lg-4 col-md-6">
                <div class="card dashboard-card border-0 shadow-sm text-center">
                    <div class="card-body">
                        <i class="fa fa-seedling dashboard-icon"></i>
                        <h5 class="card-title">Soil Health</h5>
                        <p class="card-text text-muted">Learn how to improve and maintain soil health for better crop yield.</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="card dashboard-card border-0 shadow-sm text-center">
                    <div class="card-body">
                        <i class="fa fa-cloud-sun dashboard-icon"></i>
                        <h5 class="card-title">Weather Management</h5>
                        <p class="card-text text-muted">Understand how to manage your crops based on weather patterns.</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="card dashboard-card border-0 shadow-sm text-center">
                    <div class="card-body">
                        <i class="fa fa-hand-holding-seedling dashboard-icon"></i>
                        <h5 class="card-title">Sustainable Practices</h5>
                        <p class="card-text text-muted">Adopt sustainable farming techniques to increase efficiency and protect the environment.</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="card dashboard-card border-0 shadow-sm text-center">
                    <div class="card-body">
                        <i class="fa fa-cogs dashboard-icon"></i>
                        <h5 class="card-title">Agricultural Technology</h5>
                        <p class="card-text text-muted">Explore innovative tools and technologies that can boost your farm's productivity.</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="card dashboard-card border-0 shadow-sm text-center">
                    <div class="card-body">
                        <i class="fa fa-recycle dashboard-icon"></i>
                        <h5 class="card-title">Waste Management</h5>
                        <p class="card-text text-muted">Learn how to manage farm waste and convert it into valuable resources.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</body>
</html>
