package com.proyecto.curso.view.utileria;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;


@ManagedBean(eager=true)
@ApplicationScoped
public class ValidadorView {
	
	private ExpresionRegular validaCorreo;
	private ExpresionRegular validaNumerico;
	private ExpresionRegular validaAlfabetico;
	private ExpresionRegular validaAlfanumerico;
	private ExpresionRegular validaCadena1;
	private ExpresionRegular validaCadena2;
	private ExpresionRegular validaCadena3;
	private ExpresionRegular validaCadena4;
	private ExpresionRegular validaCadena5;
	private ExpresionRegular validaNumeroCaracter1;
	private ExpresionRegular validaNumeroCaracter2;
	private ExpresionRegular validaNumeroCaracter3;
	private ExpresionRegular validaRFCFisica;
	private ExpresionRegular validaMonto;
	private ExpresionRegular validaCURP;
	private ExpresionRegular validaCalle;
	private ExpresionRegular validaClabe;

	
	@PostConstruct
	public void inicializa(){
		
		//Valida correo
		validaCorreo = new ExpresionRegular();
		validaCorreo.setStrExpresion("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)");
		validaCorreo.setStrMensaje("{0}: Formato de correo invalido");
		
		//Letras, letras espaciales, espacio y punto
		validaCadena1 = new ExpresionRegular();
		validaCadena1.setStrExpresion("^[A-Za-zá-úÁ-Ú .]*$");
		validaCadena1.setStrMensaje("{0}: Campo solo puede contener letras, espacio en blanco y punto");
		
		//Letras, numeros y punto
		validaCadena2 = new ExpresionRegular();
		validaCadena2.setStrExpresion("^[A-Za-z0-9.]*$");
		validaCadena2.setStrMensaje("{0}: Campo solo puede contener letras, numeros y punto");		
		
		//Letras, letras especiales, espacio, punto, coma
		validaCadena3 = new ExpresionRegular();
		validaCadena3.setStrExpresion("^[A-Za-zá-úÁ-Ú .,]*$");
		validaCadena3.setStrMensaje("{0}: Campo solo puede contener letras, espacio en blanco coma y punto");
		
		//Letras, letras espaciales, numeros, espacio y punto
		validaCadena4 = new ExpresionRegular();
		validaCadena4.setStrExpresion("^[A-Za-zá-úÁ-Ú0-9 .]*$");
		validaCadena4.setStrMensaje("{0}: Campo solo puede contener letras, numeros, espacio en blanco y punto");
		
		//Letras, letras espaciales, espacio, punto y guion medio
		validaCadena5 = new ExpresionRegular();
		validaCadena5.setStrExpresion("^[A-Za-zá-úÁ-Ú .-]*$");
		validaCadena5.setStrMensaje("{0}: Campo solo puede contener letras, numeros, punto y guion medio (-)");	
		
		//Valida calle
		validaCalle = new ExpresionRegular();
		validaCalle.setStrExpresion("^[A-Za-zá-úÁ-Ú0-9 .,-/]*$");
		validaCalle.setStrMensaje("{0}: Campo solo puede contener letras, numeros, espacio en blanco, coma, punto, guion y diagonal");
		
		//Solo letras, sin letras especiales
		validaAlfabetico = new ExpresionRegular();
		validaAlfabetico.setStrExpresion("^[A-Za-z]*$");
		validaAlfabetico.setStrMensaje("{0}: Campo solo puede contener letras, sin espacios");
		
		//Solo letras y numeros, sin letras especiales
		validaAlfanumerico = new ExpresionRegular();
		validaAlfanumerico.setStrExpresion("^[A-Za-z0-9]*$");
		validaAlfanumerico.setStrMensaje("{0}: Campo solo puede contener letras y números, sin espacios y sin punto");
		
		//Solo numeros
		validaNumerico = new ExpresionRegular();
		validaNumerico.setStrExpresion("^[0-9]*$");
		validaNumerico.setStrMensaje("{0}: Campo solo puede contener números");
		
		validaNumeroCaracter1 = new ExpresionRegular();
		validaNumeroCaracter1.setStrExpresion("^[A-Za-z0-9.-]*$");
		validaNumeroCaracter1.setStrMensaje("{0}: Campo solo puede contener números, letras, punto y guion");
		
		validaNumeroCaracter2 = new ExpresionRegular();
		validaNumeroCaracter2.setStrExpresion("^[A-Za-z0-9.-/]*$");
		validaNumeroCaracter2.setStrMensaje("{0}: Campo solo puede contener números, letras, punto, guion y /");
		
		//Valida letras, letras especiales, espacio, coma, punto, guion y /
		validaNumeroCaracter3 = new ExpresionRegular();
		validaNumeroCaracter3.setStrExpresion("^[A-Za-zá-úÁ-Ú0-9 .,-/]*$");
		validaNumeroCaracter3.setStrMensaje("{0}: Campo solo puede contener números, letras, espacio, punto, guion y /");
		
		//Solo letras y numeros, de longitud 13
		validaRFCFisica = new ExpresionRegular();
		validaRFCFisica.setStrExpresion("^[A-Za-z0-9]{13}$");
		validaRFCFisica.setStrMensaje("{0}: Campo solo puede contener letras, numeros y debe ser de 13 caracteres");
		
		//Valida cantidades de moneda.
		validaMonto = new ExpresionRegular();
		validaMonto.setStrExpresion("^[0-9]+(\\.[0-9]{1,2})?$");
		validaMonto.setStrMensaje("{0}: Campo solo puede contener números y punto decimal, con el formato ####.##");
		
		//Valida CURP
		validaCURP = new ExpresionRegular();
		validaCURP.setStrExpresion("^[A-Za-z0-9]{18}$");
		validaCURP.setStrMensaje("{0}: Campo solo puede contener letras, numeros y debe ser de 18 caracteres");
		
		//Valida CLABE de bancos
		validaClabe = new ExpresionRegular();
		validaClabe.setStrExpresion("^[0-9]{18}$");
		validaClabe.setStrMensaje("{0}: Campo solo puede contener numeros y debe ser de 18 digitos");
		
		
	}

	public ExpresionRegular getValidaCorreo() {
		return validaCorreo;
	}

	public void setValidaCorreo(ExpresionRegular validaCorreo) {
		this.validaCorreo = validaCorreo;
	}

	public ExpresionRegular getValidaNumerico() {
		return validaNumerico;
	}

	public void setValidaNumerico(ExpresionRegular validaNumerico) {
		this.validaNumerico = validaNumerico;
	}

	public ExpresionRegular getValidaAlfabetico() {
		return validaAlfabetico;
	}

	public void setValidaAlfabetico(ExpresionRegular validaAlfabetico) {
		this.validaAlfabetico = validaAlfabetico;
	}

	public ExpresionRegular getValidaAlfanumerico() {
		return validaAlfanumerico;
	}

	public void setValidaAlfanumerico(ExpresionRegular validaAlfanumerico) {
		this.validaAlfanumerico = validaAlfanumerico;
	}

	public ExpresionRegular getValidaCadena1() {
		return validaCadena1;
	}

	public void setValidaCadena1(ExpresionRegular validaCadena1) {
		this.validaCadena1 = validaCadena1;
	}

	public ExpresionRegular getValidaCadena2() {
		return validaCadena2;
	}

	public void setValidaCadena2(ExpresionRegular validaCadena2) {
		this.validaCadena2 = validaCadena2;
	}

	public ExpresionRegular getValidaRFCFisica() {
		return validaRFCFisica;
	}

	public void setValidaRFCFisica(ExpresionRegular validaRFCFisica) {
		this.validaRFCFisica = validaRFCFisica;
	}

	public ExpresionRegular getValidaMonto() {
		return validaMonto;
	}

	public void setValidaMonto(ExpresionRegular validaMonto) {
		this.validaMonto = validaMonto;
	}

	public ExpresionRegular getValidaCURP() {
		return validaCURP;
	}

	public void setValidaCURP(ExpresionRegular validaCURP) {
		this.validaCURP = validaCURP;
	}

	public ExpresionRegular getValidaCadena3() {
		return validaCadena3;
	}

	public void setValidaCadena3(ExpresionRegular validaCadena3) {
		this.validaCadena3 = validaCadena3;
	}

	public ExpresionRegular getValidaCalle() {
		return validaCalle;
	}

	public void setValidaCalle(ExpresionRegular validaCalle) {
		this.validaCalle = validaCalle;
	}

	public ExpresionRegular getValidaNumeroCaracter1() {
		return validaNumeroCaracter1;
	}

	public void setValidaNumeroCaracter1(ExpresionRegular validaNumeroCaracter1) {
		this.validaNumeroCaracter1 = validaNumeroCaracter1;
	}

	public ExpresionRegular getValidaCadena4() {
		return validaCadena4;
	}

	public void setValidaCadena4(ExpresionRegular validaCadena4) {
		this.validaCadena4 = validaCadena4;
	}

	public ExpresionRegular getValidaCadena5() {
		return validaCadena5;
	}

	public void setValidaCadena5(ExpresionRegular validaCadena5) {
		this.validaCadena5 = validaCadena5;
	}

	public ExpresionRegular getValidaNumeroCaracter2() {
		return validaNumeroCaracter2;
	}


	public void setValidaNumeroCaracter2(ExpresionRegular validaNumeroCaracter2) {
		this.validaNumeroCaracter2 = validaNumeroCaracter2;
	}

	public ExpresionRegular getValidaNumeroCaracter3() {
		return validaNumeroCaracter3;
	}

	public void setValidaNumeroCaracter3(ExpresionRegular validaNumeroCaracter3) {
		this.validaNumeroCaracter3 = validaNumeroCaracter3;
	}

	public ExpresionRegular getValidaClabe() {
		return validaClabe;
	}

	public void setValidaClabe(ExpresionRegular validaClabe) {
		this.validaClabe = validaClabe;
	}
	
	
}