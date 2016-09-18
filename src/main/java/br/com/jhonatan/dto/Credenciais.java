package br.com.jhonatan.dto;

public class Credenciais {
	
	private String user;
    private String pw;
    
    public Credenciais() {}

    public Credenciais(final String user, final String pw) {
        this.user = user;
        this.pw = pw;
    }

    public String getUser() {
        return user;
    }

    public String getPw() {
        return pw;
    }

	public void setUser(final String user) {
		this.user = user;
	}

	public void setPw(final String pw) {
		this.pw = pw;
	}
    

}
