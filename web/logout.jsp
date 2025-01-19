<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Logout</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card shadow">
                    <div class="card-header text-center">
                        <h3>Logging Out</h3>
                    </div>
                    <div class="card-body text-center">
                        <p>You have been successfully logged out.</p>
                        <p>Redirecting you to the homepage...</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script>
        // Redirect to index.html after 2 seconds
        setTimeout(function() {
            window.location.href = "index.jsp";  // Redirect to the homepage (index.html)
        }, 2000);
    </script>
</body>
</html>
