package archimedes;

import java.util.ArrayList;
import java.util.List;

import archimedes.acf.checker.ModelChecker;
import archimedes.acf.checker.ModelCheckerDomainSetForAllColumns;
import archimedes.acf.event.CodeFactoryListener;
import archimedes.gui.checker.ModelCheckerMessageListFrameListener;
import archimedes.legacy.acf.event.CodeFactoryProgressionEvent;
import archimedes.legacy.acf.event.CodeFactoryProgressionEventProvider;
import archimedes.legacy.acf.event.CodeFactoryProgressionListener;
import archimedes.legacy.acf.gui.StandardCodeFactoryProgressionFrameUser;
import archimedes.legacy.checkers.ModelCheckerNoComplexPrimaryKey;
import archimedes.model.CodeFactory;
import archimedes.model.DataModel;
import baccara.gui.GUIBundle;

public class CRUDJPABackendACF
		implements CodeFactory, CodeFactoryProgressionEventProvider, StandardCodeFactoryProgressionFrameUser {

	private DataModel dataModel = null;
	private GUIBundle guiBundle = null;
	private List<CodeFactoryListener> listeners = new ArrayList<>();
	private List<CodeFactoryProgressionListener> progressListeners = new ArrayList<>();

	public static void main(String[] args) {
		System.out.println(new CRUDJPABackendACF().getVersion());
	}

	@Override
	public void addCodeFactoryListener(CodeFactoryListener listener) {
		this.listeners.add(listener);
	}

	@Override
	public boolean generate(String out) {
		// Change to a Alexandrian model first.
		return false;
	}

	@Override
	public void removeCodeFactoryListener(CodeFactoryListener listener) {
		this.listeners.remove(listener);
	}

	@Override
	public void setDataModel(DataModel dataModel) {
		this.dataModel = dataModel;
	}

	@Override
	public GUIBundle getGUIBundle() {
		return this.guiBundle;
	}

	@Override
	public ModelChecker[] getModelCheckers() {
		return new ModelChecker[] { //
				new ModelCheckerDomainSetForAllColumns(this.getGUIBundle()), //
				new ModelCheckerNoComplexPrimaryKey(this.getGUIBundle()) //
		};
	}

	@Override
	public String getName() {
		return "REST server code factory";
	}

	@Override
	public String[] getResourceBundleNames() {
		return new String[] { //
				"rest-server" //
		};
	}

	@Override
	public String getVersion() {
		return "1.0.0";
	}

	@Override
	public void setGUIBundle(GUIBundle guiBundle) {
		this.guiBundle = guiBundle;
	}

	@Override
	public void setModelCheckerMessageListFrameListeners(ModelCheckerMessageListFrameListener... l) {
		// NOP
	}

	@Override
	public void addCodeFactoryProgressionListener(CodeFactoryProgressionListener listener) {
		if (listener != null) {
			this.progressListeners.add(listener);
		}
	}

	@Override
	public void removeCodeFactoryProgressionListener(CodeFactoryProgressionListener listener) {
		if (listener != null) {
			this.progressListeners.remove(listener);
		}
	}

	protected void fireCodeFactoryProgressEvent(CodeFactoryProgressionEvent event) {
		this.progressListeners //
				.forEach(l -> {
					try {
						l.progressionDetected(event);
					} catch (Exception e) {
						printStackTrace(e);
					}
				});
	}

	private void printStackTrace(Exception e) {
		e.printStackTrace();
	}

}