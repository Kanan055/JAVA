let psStorageString = localStorage.getItem("ps-shopping-pss")
let pss = []
let seller = localStorage.getItem("ps-shopping-currentseller")
if (psStorageString != null) {
    pss = JSON.parse(psStorageString)
}

function changeToIndexPage() {
    window.location.href = "index.html"
}
function changeToPagePsShoppingPage() {
    window.location.href = "ps-shopping.html"
}
function addPs(event) {
    event.preventDefault()
    let category = document.getElementById("category").value
    let name = document.getElementById("name").value
    let ram= document.getElementById("ram").value
    let price = document.getElementById("price").value
    let image = document.getElementById("image").value
    let isnew = document.getElementById("isnew").value

    let cpu = document.getElementById("cpu").value
    let rom = document.getElementById("rom").value
    let type = document.getElementById("type").value
    let info= document.getElementById("info").value
    let os = document.getElementById("os").value
    let vidio = document.getElementById("vidio").value

    // Muraciet etdiyim "id" ler ingdili terefinden qebul olunan shorthand lerdir
    const ps = {}
    ps.id = pss.length + 1
    ps.category = category
    ps.name = name
    ps.ram = ram
    ps.price = price
    ps.image = image
    ps.isnew = isnew
    ps.cpu = cpu
    ps.rom = rom
    ps.type = type
    ps.info = info
    ps.os = os
    ps.vidio = vidio
    ps.seller = seller

    pss.push(ps)
    localStorage.setItem("ps-shopping-pss", JSON.stringify(pss))
    setTimeout(() => {
        window.location.reload()
    }, 2000)

}
function loadValues(id) {
    let ps = {}
    for (let i = 0; i < pss.length; i++) {
        if (pss[i].id === id) {
            ps = pss[i]
            break
        }
    }
    let editcategory = document.getElementById("editcategory")
    let editname = document.getElementById("editname")
    let editram = document.getElementById("editram")
    let editprice = document.getElementById("editprice")
    let editimage = document.getElementById("editimage")
    let editisnew = document.getElementById("editisnew")

    let editcpu= document.getElementById("editcpu")
    let editrom= document.getElementById("editrom")
    let edittype = document.getElementById("edittype")
    let editinfo = document.getElementById("editinfo")
    let editos = document.getElementById("editos")
    let editvidio = document.getElementById("editvidio")
    document.getElementById("editpsid").innerHTML = id

    editcategory.value = ps.category
    editname.value = ps.name
    editram.value = ps.ram
editprice.value=ps.price
    editimage.value = ps.image
    editisnew.value = ps.isnew
    editcpu.value = ps.cpu
    editrom.value = ps.rom
    edittype.value = ps.type
    editinfo.value = ps.info
    editos.value = ps.os
    editvidio.value = ps.vidio
}
function editPs(event) {
    event.preventDefault()
    let id = Number(document.getElementById("editpsid").innerText)
    let editcategory = document.getElementById("editcategory").value
    let editname = document.getElementById("editname").value
    let editram = document.getElementById("editram").value
    let editprice = document.getElementById("editprice").value
    let editimage = document.getElementById("editimage").value
    let editisnew = document.getElementById("editisnew").value

    let editcpu = document.getElementById("editcpu").value
    let editrom = document.getElementById("editrom").value
    let edittype = document.getElementById("edittype").value
    let editinfo = document.getElementById("editinfo").value
    let editos = document.getElementById("editos").value
    let editvidio = document.getElementById("editvidio").value



    for (let i = 0; i < pss.length; i++) {
        if (pss[i].id === id) {
            pss[i].category = editcategory
            pss[i].name = editname
            pss[i].ram = editram
            pss[i].price = editprice
            pss[i].Image = editimage
            pss[i].isNew = editisnew

            pss[i].Cpu = editcpu
            pss[i].Rom = editrom
            pss[i].type = edittype
            pss[i].info = editinfo
            pss[i].os = editos
            pss[i].vidio = editvidio
            break
        }
    }
    localStorage.setItem("ps-shopping-pss", JSON.stringify(pss))
    window.location.reload()
}










function loadPss() {

    let tableContent = document.getElementById("pss-table-content")
    tableContent.innerHTML = ""

    for (let i = 0; i < pss.length; i++) {
        const ps = pss[i]
      
        if (ps.seller == seller) {
            let id = ps.id
            let name = ps.category + " " + ps.name
            let image = ps.image
            let price = ps.price

            let tr = document.createElement("tr")
            let idTd = document.createElement("td")
            let nameTd = document.createElement("td")
            let imageTd = document.createElement("td")
            let priceTd = document.createElement("td")
            let operationsTd = document.createElement("td")

            idTd.innerText = id
            nameTd.innerText = name
            priceTd.innerText = price
            let img = document.createElement("img")
            img.src = image
            img.style.width = "25%"
            img.style.height = "auto"
            img.style.borderRadius = "50%"

            imageTd.appendChild(img)
            let editButton = document.createElement("button")
            let deleteButton = document.createElement("button")
            editButton.setAttribute("class", "btn btn-primary mx-1")
            editButton.setAttribute("data-bs-target", "#edit-modal")
            editButton.setAttribute("data-bs-toggle", "modal")
            editButton.setAttribute("onclick", `loadValues(${id})`)
            deleteButton.setAttribute("class", "btn btn-danger mx-1")
           deleteButton.setAttribute("onclick", `deletePs(${id})`)
            editButton.innerText = "Redakte et"
            deleteButton.innerText = "Sil"

            operationsTd.appendChild(editButton)
            operationsTd.appendChild(deleteButton)

            tr.appendChild(idTd)
            tr.appendChild(nameTd)
            tr.appendChild(imageTd)
            tr.appendChild(priceTd)
            tr.appendChild(imageTd)
            tr.appendChild(operationsTd)

            tableContent.appendChild(tr)


        }
    }
}
function deletePs(id) {
    for (let i = 0; i < pss.length; i++) {
        let ps = pss[i]

        if(ps.id===id){
            pss.splice(i,1)
            
            localStorage.setItem("ps-shopping-pss", JSON.stringify(pss))
            loadPss()
            break
        }


    }
}
loadPss()