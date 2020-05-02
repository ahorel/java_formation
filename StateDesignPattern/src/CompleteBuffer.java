
public abstract class CompleteBuffer {
	protected StringBuffer bf = new StringBuffer();
	protected static final String MODE_1 = String.valueOf(ConstantesES2.CODE_MODE_TRAITEMENT_M1);
	protected static final String MODE_2 = String.valueOf(ConstantesES2.CODE_MODE_TRAITEMENT_M2);
	public abstract void completeBuffer(String str);
	public abstract void prev(Buffer buffer);
	public abstract void next(Buffer buffer);
}

public class BufferEtape1 extends CompleteBuffer {
	private static StringBuffer bf;
	
	public BufferEtape1() {
		this.bf = super.bf;
	}
	public void completeBuffer(String str) {
		if (MODE_1.equals(session4Info2BO.getCodeModeTraitement()) ) {
			CoupureS1 coupure = CoupureS1.getByCode(Integer.parseInt(session4Info2BO.getEs1CodeCoupure()));
			bf.append(coupure == null? 0+";" : String.valueOf(coupure.getValeurFaciale())+";");							
		}else{
			CoupureS2 coupure = CoupureS2.getByCode(Integer.parseInt(session4Info2BO.getEs2CodeCoupure()));
			bf.append(coupure == null? 0+";" : String.valueOf(coupure.getValeurFaciale())+";");
		}
	}
	
	@Override
	public void prev(Buffer buffer) {
		//ne rien faire
	}

	@Override
	public void next(Buffer buffer) {
		buffer.setBuffer(new BufferEtape2());
	}
}

public class BufferEtape2 extends CompleteBuffer {
	private StringBuffer bf;
	
	public BufferEtape2() {
		this.bf = super.bf;
	}
	
	public void completeBuffer(String str) {
		if(session4Info2BO.getPoste().getRattachementADate(session4Info2BO.getDate())!=null){
		    bf.append(sdf.format(session4Info2BO.getDate())+";");
			//codeUA = session4Info2BO.getPoste().getRattachementADate(session4Info2BO.getDate()).getLigne().getCodeUA();
		}
	}

	@Override
	public void prev(Buffer buffer) {
		buffer.setBuffer(new BufferEtape1());
	}

	@Override
	public void next(Buffer buffer) {
		// TODO Auto-generated method stub
		buffer.setBuffer(new BufferEtape3());
	}
	 
}

public class BufferEtape3  extends CompleteBuffer {
	StringBuffer bf;
	public BufferEtape3() {
		this.bf = super.bf;
	}
	public void completeBuffer(String str) {
		if (session4Info2BO.getNumeroOrdre() > 200) {
			bf.append(session4Info2BO.getNumeroOrdre()-100+";");
		} else {
			bf.append(session4Info2BO.getNumeroOrdre()+";");
		}	
	}

	@Override
	public void prev(Buffer buffer) {
		buffer.setBuffer(new BufferEtape2());
	}

	@Override
	public void next(Buffer buffer) {
		// TODO Auto-generated method stub
	}
	 
}

public class Buffer {
	public CompleteBuffer buffer = new BufferEtape1();
	

	public CompleteBuffer getBuffer() {
		return buffer;
	}

	public void nextBuffer() {
		buffer.next(this);
	}
	
	public void previousBuffer() {
		buffer.prev(this);
	}
	
	public void setBuffer(CompleteBuffer buffer) {
		this.buffer = buffer;
	}
	
}

public class Handler {
	public void performReal() {
		Buffer buffer = new Buffer();
		buffer.buffer.completeBuffer("");
		buffer.nextBuffer();
		buffer.buffer.completeBuffer("");
		buffer.nextBuffer();
	}
}