$(document).ready(function () {
  const url = window.location.href;

  console.log(url);

  const admin = document.getElementById("admin");
  const admin_plus = document.getElementById("admin-plus");
  if (url.includes("/user/all")) {
    admin.classList.add("s-active");
    admin_plus.classList.add("s-active");
    document.getElementById("all-users").classList.add("s-active");
  } else if (url.includes("/product/add")) {
    admin.classList.add("s-active");
    admin_plus.classList.add("s-active");
    document.getElementById("add-stock").classList.add("s-active");
  } else if (url.includes("/order/all")) {
    admin.classList.add("s-active");
    admin_plus.classList.add("s-active");
    document.getElementById("view-orders").classList.add("s-active");
  } else if (url.includes("/product/all")) {
    admin.classList.add("s-active");
    admin_plus.classList.add("s-active");
    document.getElementById("view-stock").classList.add("s-active");
  }

  if (url.includes("?login=true"))
    toast("You Have Logged In Successful", "text-success", "border-success");
  else if (url.includes("?user-exists"))
    toast(
      "You should Logout first to Login again.",
      "text-danger",
      "border-danger"
    );
  else if (url.includes("?sign-up=true"))
    toast("Registration Successful", "text-success", "border-success");
  else if (url.includes("?logout=true"))
    toast("You have Logged Out Successful", "text-success", "border-success");
  else if (url.includes("?add-product=true"))
    toast("Product Added Successful", "text-success", "border-success");
  else if (url.includes("?update-user=true"))
    toast("User details updated Successful", "text-success", "border-success");
  else if (url.includes("?product-update=true"))
    toast("Product Updated Successful", "text-success", "border-success");
  else if (url.includes("?delete-product=true"))
    toast("Product Deleted Successful", "text-danger", "border-danger");
  else if (url.includes("?order=true"))
    toast("You Order is Successful Placed", "text-success", "border-success");

  function toast(message, textColor, borderColor) {
    const alert = document.getElementById("toast-alert");
    const body = document.getElementById("toast-body");

    body.classList.add(textColor);
    body.innerHTML = message;

    alert.classList.add(borderColor);
    $('.toast').toast({ delay: 9000 });
    $('.toast').toast("show");
  }
});
