package br.com.javaparaweb.financeiro.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.javaparaweb.financeiro.conta.Conta;

@ManagedBean
@RequestScoped
public class ContaBean {
private Conta selecionada = new Conta();
private List<Conta> lista = null;

@ManagedProperty(value="#{contextoBean}")
private ContextoBean contextoBean;

public String salvar() {
	return null;
}

public String excluir() {
	return null;
}

public String tornarFavorita() {
	return null;
}

public Conta getSelecionada() {
	return selecionada;
}

public void setSelecionada(Conta selecionada) {
	this.selecionada = selecionada;
}

public List<Conta> getLista() {
	return lista;
}

public void setLista(List<Conta> lista) {
	this.lista = lista;
}

public ContextoBean getContextoBean() {
	return contextoBean;
}

public void setContextoBean(ContextoBean contextoBean) {
	this.contextoBean = contextoBean;
}


}
