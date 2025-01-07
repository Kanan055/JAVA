let psStorageString = localStorage.getItem("ps-shopping-pss")
let pss = []
let basket = []
let categories = []
let categoryClicked = false
let basketStorageString = localStorage.getItem("ps-shopping-basket")
if (psStorageString != null) {
    pss = JSON.parse(psStorageString)
}
if (basketStorageString != null) {
    basket = JSON.parse(basketStorageString)
}
function changeToIndexPage() {
    window.location.href = "index.html"
}
function loadCategories() {
    let list = document.getElementById("categories-list").children

    for (let i = 0; i < list.length; i++) {
        categories.push(list[i].innerText)
    }
}

function selectedCategory(element){
    let category = element.innerText;
    element.style.color = "Blue";
    element.style.fontWeight = "bold";
    loadPss(category);

    if(categoryClicked ==  false){
        categoryClicked = true;
    }else{
        loadPss("");
        searchCateqory("");
        categoryClicked = false;
    }
}

function searchCateqory(txt) {
    let list = document.getElementById("categories-list")
    let newCategories = []
    for (let i = 0; i < categories.length; i++) {
        let element = categories[i].toLowerCase()
        if (element.indexOf(txt) != -1) {

            newCategories.push(element)
        }
    }
    list.innerHTML = ""
    for (let i = 0; i < newCategories.length; i++) {
        let li = document.createElement("li")
        li.setAttribute("class", "list-group-item")
        li.innerText = newCategories[i]
        list.appendChild(li)
    }


}
function submitBasket(event) {
    event.preventDefault()
    for (i = 0; i < basket.length; i++) {
        let psTotalPrice = Number(document.getElementById("basket-ps" + basket[i].ps.id).innerText)
        let psQuantity = Number(psTotalPrice / Number(basket[i].ps.price))
        if (psQuantity > 0) {
            basket[i].quantity = psQuantity
            basket[i].totalPrice = psTotalPrice
            localStorage.setItem("ps-shopping-basket", JSON.stringify(basket))
            setTimeout(() => {
                window.location.href = "confirmation-form.html"
            }, 1000)
        } else {
            alert(basket[i].ps.id + "id olan komputerin miqdari sehv qeyd olunub")
        }
    }

}


function deletePsFromBasket(id) {

    for (let i = 0; i < basket.length; i++) {
        let basketItem = basket[i]
        let ps = basketItem.ps

        if (ps.id == id) {
            basket.splice(i, 1)
            calculatePsTotalPrice()
            localStorage.setItem("ps-shopping-basket", JSON.stringify(basket))
            loadBasket()
        }


    }
}
function changeValuesWhenModalOpened(ps) {

    document.getElementById("modal-ps-name").innerText = `${ps.name}`
    document.getElementById("modal-ps-price").innerText = ps.price
    document.getElementById("modal-ps-isnew").innerText = `${ps.isnew}`;

    document.getElementById("modal-ps-cpu").innerText = ps.cpu
    document.getElementById("modal-ps-rom").innerText = ps.rom
    document.getElementById("modal-ps-type").innerText = ps.type


}
function calculatePsTotalPrice() {
    let sum = 0
    for (let i = 0; i < basket.length; i++) {
        let psTotalPrice = Number(document.getElementById("basket-ps" + basket[i].ps.id).innerText)
        sum = sum + psTotalPrice
    }
    document.getElementById("basket-total-price").innerText = sum
}
function calculatePsPrice(ps, quantity) {
    document.getElementById("basket-ps" + ps.id).innerText = Number(quantity) * ps.price
    calculatePsTotalPrice()
}
function loadBasket() {
    let basketTable = document.getElementById("basket-table-content")
    basketTable.innerHTML = ""
    for (let i = 0; i < basket.length; i++) {
        let basketItem = basket[i]
        let ps = basketItem.ps
        let tr = document.createElement("tr")
        let idTd = document.createElement("td")
        let nameTd = document.createElement("td")
        let priceTd = document.createElement("td")
        let imageTd = document.createElement("td")
        let quantityTd = document.createElement("td")
        let totalPriceTd = document.createElement("td")

        totalPriceTd.id = "basket-ps" + ps.id
        let operationsTd = document.createElement("td")
        idTd.innerText = ps.id
        nameTd.innerText = ps.name
        priceTd.innerHTML = ps.price
        let img = document.createElement("img")
        img.src = ps.image

        img.style.height = "50px"
        img.style.width = "50px"
        imageTd.appendChild(img)
        let quantityInput = document.createElement("input")
        quantityInput.type = "number"
        quantityInput.id = "basket-ps-quantity" + ps.id
        quantityInput.setAttribute("oninput", `calculatePsPrice(${JSON.stringify(ps)},this.value);`)
        quantityInput.setAttribute("requared", "on")
        quantityInput.id = "basket-ps-quantity" + ps.id
        quantityInput.min = "1"
        quantityInput.max = "10"

        quantityInput.placeholder = "Miqdari qeyd edin:"
        let deleteButton = document.createElement("button")
        deleteButton.type = "button"
        deleteButton.setAttribute("class", "btn btn-danger")
        deleteButton.innerText = "Sil"
        deleteButton.setAttribute("onclick", `deletePsFromBasket(${ps.id})`)
        quantityTd.appendChild(quantityInput)
        let validSpan = document.createElement("span")
        let invalidSpan = document.createElement("span")

        quantityTd.appendChild(validSpan)
        quantityTd.appendChild(invalidSpan)
        operationsTd.appendChild(deleteButton)
        tr.appendChild(idTd)
        tr.appendChild(nameTd)
        tr.appendChild(priceTd)
        tr.appendChild(imageTd)
        tr.appendChild(quantityTd)
        tr.appendChild(totalPriceTd)
        tr.appendChild(operationsTd)
        basketTable.appendChild(tr)
    }
}
function resetBasket() {
    basket = []
    localStorage.setItem("ps-shopping-basket", JSON.stringify(basket))
    loadBasket()
}

function addToBasket(ps) {
    let allowToAdd = true
    for (let i = 0; i < basket.length; i++) {
        let basketPs = basket[i]
        if (basketPs.ps.id === ps.id) {
            allowToAdd = false
            alert("Sebetde var")
        }
    }
    if (allowToAdd == true) {

        let basketItem = {}
        basketItem.ps = ps
        basket.push(basketItem)
        localStorage.setItem("ps-shopping-basket", JSON.stringify(basket))
    }
}
function loadPss(searchTxt) {
    let pssContent = document.getElementById("cards-content")
    pssContent.innerHTML = `<div class="modal" id="ps-info-modal">` +
        `<div class="modal-dialog modal-lg">` +
        `<div class="modal-content">` +
        `<div class="modal-header">` +
        `<span></span>` +
        `<h1>Komputerin Muelumatlari</h1>` +
        `<span></span>` +
        `</div>` +
        `<div class="modal-body">` +
        `<img id="modal-card-image" class="img-fluid">` +
        `<div class="row"` +
        `<div class="col-6">`+
             `<div class="h4">Ad: <span id="modal-ps-name"></span></div>` +
        `<div class="h4">Qiymet: <span id="modal-ps-price"></span></div>` +
        `<div class="h4">Yeni: <span id="modal-ps-isnew"></span></div>` +
        `</div>`+
       
        
        `<div class="col-6">`+
              `<div class="h4">Merkezi prosessor: <span id="modal-ps-cpu"></span></div>` +
        `<div class="h4">Daimi yaddas: <span id="modal-ps-rom"></span></div>` +
        `<div class="h4">Daimi yaddas tipi: <span id="modal-ps-type"></span></div>` +
        `</div>` +
        `</div>` +
        `</div>` +
        `</div>` +
        `</div>` +
        `</div>` +
        `</div>`;
      
       
    for (let i = 0; i < pss.length; i++) {
        let allow = false

        let ps = pss[i]
        let psFullName = ps.category + " " + ps.name
        if (searchTxt.trim().length > 0) {
            if (psFullName.toLowerCase().indexOf(searchTxt.toLowerCase()) != -1) {
                allow = true
            }
        } else {
            allow = true
        }
        if (allow == true) {
            let columnDiv = document.createElement("div")
            columnDiv.setAttribute("class", "card", "mt-3")
            columnDiv.style.width = "380px"
            let cardDiv = document.createElement("div")
            cardDiv.setAttribute("class", "card")
            let cardImage = document.createElement("img")
            cardImage.setAttribute("data-bs-toggle", "modal")
            cardImage.setAttribute("data-bs-target", "#ps-info-modal")
            cardImage.src = ps.image
            cardImage.style.height = "220px"
            cardImage.style.width = "270px"
            cardImage.style.marginLeft = "40px"
            cardImage.setAttribute("data-bs-toggle", "modal")
            cardImage.setAttribute("data-bs-target", "#ps-info-modal")
            cardImage.setAttribute("onclick", `changeValuesWhenModalOpened(${JSON.stringify(ps)})`)
            let cardBody = document.createElement("div")
            cardBody.setAttribute("class", "card-body")
            cardBody.style.width = "200px"
            let cardTitle = document.createElement("div")
            cardTitle.setAttribute("class", "card-title")
            cardTitle.innerText = ps.category + " " + ps.name
            let cardText = document.createElement("div")
            cardText.setAttribute("class", "card-text")


            cardText.innerHTML = `<b>Ad:</b>${ps.name}<br>` + `<b>Saticinin adi:</b>${ps.seller}<br>` + `<b>Qiymət:</b>${ps.price}`
            cardBody.appendChild(cardTitle)
            cardBody.appendChild(cardText)
            let addBasketButton = document.createElement("button")
            addBasketButton.setAttribute("class", "btn btn-primary")
            addBasketButton.innerText = "Sebete at"
            addBasketButton.style.height = "40px"
            addBasketButton.style.width = "367px"

            addBasketButton.setAttribute("onclick", `addToBasket(${JSON.stringify(ps)})`)
            cardDiv.appendChild(cardImage)
            cardDiv.appendChild(cardBody)
            cardDiv.appendChild(addBasketButton)
            columnDiv.appendChild(cardDiv)
            pssContent.appendChild(columnDiv)

        }


    }

}
loadPss("")
loadCategories()