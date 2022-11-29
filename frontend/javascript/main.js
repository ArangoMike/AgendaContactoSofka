
const id = document.querySelector('.id');
const nombre = document.querySelector('.nombre');
const telefono = document.querySelector('.numero');
const correo = document.querySelector('.correo');
const fechaNacimiento = document.querySelector('.fechaNacimiento');
const btnAgregarTarea = document.querySelector('.btn-agregar-tarea');
const btnActualizarContacto = document.querySelector('.btn-actualizar-contacto');

const listadoContactos = document.querySelector('.listado-contactos')


// Consumo de api post para agregar un nuevo contacto a la BD 
btnAgregarTarea.addEventListener("click", function onclick() {

    var body = {
        "nombre": nombre.value,
        "telefono": telefono.value,
        "correo": correo.value,
        "fechaNacimiento": fechaNacimiento.value,
        "activo": "ON"
    }

    fetch('http://localhost:9090/contact', {
        method: 'POST',
        body: JSON.stringify(body),
        headers: {
            'Content-Type': 'application/json'
        },
        mode: 'cors',
    })
        .then(response => response.json())
        .then(res => {
            document.getElementById('resultado').innerHTML = "!CONTACTO AGREGADO!, recarga para verlo reflejado"
            let nombreContacto = document.getElementById('nombre').innerHTML = res.nombre
            let telefonContacto = document.getElementById('telefono').innerHTML = res.telefono
            let correoContacto = document.getElementById('correo').innerHTML = res.correo
            let fechaNacimientoContacto = document.getElementById('fechaNacimiento').innerHTML = res.fechaNacimiento

        })


});

// Consumo de api get para listar todos los contactos y pintarlos en el index
fetch('http://localhost:9090/contacts', {
    method: 'GET',
    headers: {
        'Content-Type': 'application/json'
    }
})
    .then(res => res.json())
    .then(response => Object.keys(response).map(key => {
        const contactos = response[key]
        // Esta función esta en funciones.js
        crearContacto(listadoContactos, contactos, response)

    }))

// Consumo de api put para actualizar toda la información de un contacto
btnActualizarContacto.onclick = () => {

    var body = {
        "nombre": nombre.value,
        "telefono": telefono.value,
        "correo": correo.value,
        "fechaNacimiento": fechaNacimiento.value,
        "activo": "ON"
    }
    
    fetch('http://localhost:9090/contact/' + id.value, {
        method: 'PUT',
        body: JSON.stringify(body),
        headers: {
            'Content-Type': 'application/json'
        },
        mode: 'cors'
    }).then(response => response.json())
        .then(res => {
            document.getElementById('resultado').innerHTML = "!CONTACTO ACTUALIZADO!, recarga para verlo reflejado"
            document.getElementById('id').innerHTML = res.id
            document.getElementById('nombre').innerHTML = res.nombre
            document.getElementById('telefono').innerHTML = res.telefono
            document.getElementById('correo').innerHTML = res.correo
            document.getElementById('fechaNacimiento').innerHTML = res.fechaNacimiento
        })
}









