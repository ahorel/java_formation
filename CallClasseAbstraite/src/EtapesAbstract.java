
public abstract class EtapesAbstract {
	public abstract void treatment();

	protected abstract void next(Etape etape);

	protected abstract void previous(Etape etape);

}