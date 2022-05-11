// ----- On render -----
$(function() {

  $('#profile').addClass('dragging').removeClass('dragging');
});

$('#profile').on('dragover', function() {
  $('#profile').addClass('dragging')
}).on('dragleave', function() {
  $('#profile').removeClass('dragging')
}).on('drop', function(e) {
  $('#profile').removeClass('dragging hasImage');

  if (e.originalEvent) {
    let file = e.originalEvent.dataTransfer.files[0];
    console.log(file);

    let reader = new FileReader();

    //attach event handlers here...

    reader.readAsDataURL(file);
    reader.onload = function(e) {
      console.log(reader.result);
      $('#profile').css('background-image', 'url(' + reader.result + ')').addClass('hasImage');

    }

  }
})
$('#profile').on('click', function(e) {
  console.log('clicked')
  $('#mediaFile').click();
});
window.addEventListener("dragover", function(e) {
  e = e || event;
  e.preventDefault();
}, false);
window.addEventListener("drop", function(e) {
  e = e || event;
  e.preventDefault();
}, false);
$('#mediaFile').change(function(e) {

  let input = e.target;
  if (input.files && input.files[0]) {
    let file = input.files[0];

    let reader = new FileReader();

    reader.readAsDataURL(file);
    reader.onload = function(e) {
      console.log(reader.result);
      $('#profile').css('background-image', 'url(' + reader.result + ')').addClass('hasImage');
    }
  }
})