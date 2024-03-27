let Screw = {
    name: "",
    material: "",
    head: "",
    height: "",
    amount: 0,
    id: 0
}
function sendEditedSeries(){
    let xhrEdit = new XMLHttpRequest();
    Screw.name=document.getElementById("name").value;
    Screw.material=document.getElementById("material").value;
    Screw.head=document.getElementById("head").value;
    Screw.height=document.getElementById("height").value;
    Screw.amount=document.getElementById("amount").value;
    Screw.id=location.search.split("=")[1];
    let screwsJson = JSON.stringify(Screw);
    console.log(Screw);
    xhrEdit.open("POST", "save", true);
    xhrEdit.setRequestHeader('Content-Type', 'application/json');
    xhrEdit.send(screwsJson);
    location.href="read"
}