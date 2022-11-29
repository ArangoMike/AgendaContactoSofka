



// función que pinta toda la lista de contactos en el index
crearContacto = (parentNode, contacto, db) => {

    //  Se crea las etiquetas que contendran toda la lista de contactos
    let divContacto = document.createElement('div')
    let idContacto = document.createElement('p')
    let nombreContacto = document.createElement('h3')
    let telefonContacto = document.createElement('p')
    let correoContacto = document.createElement('p')
    let fechaNacimientoContacto = document.createElement('p')
    let iconoBorrar = document.createElement('span')
    let activo = document.createElement('span')

    //se agregan los valores a las etiquetas html
    idContacto.innerHTML = contacto.id
    nombreContacto.innerHTML = contacto.nombre
    telefonContacto.innerHTML = contacto.telefono
    correoContacto.innerHTML = contacto.correo
    fechaNacimientoContacto.innerHTML = contacto.fechaNacimiento
    iconoBorrar.innerHTML = 'delete_forever'
    activo.innerHTML = contacto.activo

    
    // función para eliminado lógico de la lista de contactos( el campo activo pasa a OFF)
    activo.onclick = () =>{
        
        body ={
            activo : 'OFF'
        }
        fetch('http://localhost:9090/contact/deleteat/' + contacto.id, {
        method : 'PATCH',
        body : JSON.stringify(body),
        headers : {
            'Content-Type': 'application/json'
        },
        mode :'cors'
        })
        .then(response => response.json())
        .then(res => JSON.stringify(res))
        .then()
        window.location.href = '/'
        
    }

    // Clases agregadas para efectos visuales con Css
    divContacto.classList.add('tarea')
    iconoBorrar.classList.add('material-symbols-outlined', 'icono')
    if(contacto.activo == "ON"){
        activo.classList.add('iconoG')
    }else{
    activo.classList.add('icono')
    }

    
    // función para eliminado definitivo de la BD.  Ejemplo practico, ¡NO HACER!
    iconoBorrar.onclick = () =>{
        
        fetch('http://localhost:9090/contact/' + contacto.id, {
        method : 'DELETE',
        headers : {
            'Content-Type': 'application/json'
        },
        mode :'cors'
        })
        .then(response => response.json())
        .then(res => JSON.stringify(res))
        .then(resp => console.log('Eliminado con exito,'+ resp))
        window.location.href = '/'
    }

    // agregamos al contenedor padre divContacto todas las etiquetas creadas como hijas 
    divContacto.appendChild(idContacto)
    divContacto.appendChild(nombreContacto)
    divContacto.appendChild(telefonContacto)
    divContacto.appendChild(correoContacto)
    divContacto.appendChild(fechaNacimientoContacto)
    divContacto.appendChild(iconoBorrar)
    divContacto.appendChild(activo)

    // agregamos al padre recibido por parametros el divContacto como hijo
    parentNode.appendChild(divContacto)
}