/**************** Toggle for Uploading or writing notes. ****************/
function showUploadSection() {
  document.getElementById("uploadSection").style.display = "block";
  document.getElementById("writeSection").style.display = "none";
}

function showWriteSection() {
  document.getElementById("uploadSection").style.display = "none";
  document.getElementById("writeSection").style.display = "block";
}


/**************** Validate Form ****************/
function validateForm(){
  var category = document.getElementById("category").value;
  var title = document.getElementById("title").value;
  var tags = document.getElementById("tags").value;
  var fileUpload = document.getElementById("fileUpload").value;
  var write = document.getElementById("write").value;

  if(category === "" || title === "" || tags === ""){
    alert("Please fill in all the required fields!");
    return false;
  }
  if (document.getElementById("uploadNotes").checked && fileUpload === "") {
    alert("Please select a file to upload.");
    return false;
  }
  if (document.getElementById("writeNotes").checked && write === "") {
    alert("Please write your notes.");
    return false; // Prevent form submission
  }
  var fup = document.getElementById('fileUpload');
  var fileName = fup.value;
  var ext = fileName.substring(fileName.lastIndexOf('.') + 1);
  if(ext == "pdf" || ext == "ppt" || ext == "pptx" || ext == "doc" || ext == "docx" || ext == "html" || ext == "css" || ext == "js" || ext == "ipynb" || ext == "py" || ext == ".exe" || ext == ".java"){
    alert("Submitted Successfully!");
    return true;
  }
  else{
    alert("Please select a file with extension.pdf,.ppt,.pptx,.doc,.docx,.html,.css,.js,.exe,.java,.py or.ipynb");
    fup.focus();
    return false;
  }
  // return true;
}