/*
 *  File: EventMonitoringControlPanel.java 
 *  Copyright (c) 2004-2008  Peter Kliem (Peter.Kliem@jaret.de)
 *  A commercial license is available, see http://www.jaret.de.
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package timeline;

import de.jaret.util.date.JaretDate;
import de.jaret.util.ui.timebars.TimeBarMarkerImpl;
import de.jaret.util.ui.timebars.swing.TimeBarViewer;
import de.jaret.util.ui.timebars.swing.renderer.BoxTimeScaleRenderer;
import de.jaret.util.ui.timebars.swing.renderer.DefaultGridRenderer;
import de.jaret.util.ui.timebars.swing.renderer.DefaultTimeScaleRenderer;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Control panel for the event monitoring example.
 * 
 * @author Peter Kliem
 * @version $Id: EventMonitoringControlPanel.java 974 2009-12-22 22:15:29Z kliem $
 */
public class EventMonitoringControlPanel extends JPanel {
    TimeBarViewer _viewer;
    JSlider _timeScaleSlider;
    TimeBarMarkerImpl _marker;

    public EventMonitoringControlPanel(TimeBarViewer viewer, TimeBarMarkerImpl marker, int initalSecondsDisplayed) {
        _viewer = viewer;
        _marker = marker;
        this.setPreferredSize(new Dimension(1000, 100));
        setLayout(new FlowLayout());
        createControls(initalSecondsDisplayed);
    }

    private void createControls(int initialSeconds) {
        final double slidermax = 100; // slider maximum (does not really matter)
        final float factor = 1.1f;
        _timeScaleSlider = new JSlider(0, (int) slidermax);

        _timeScaleSlider.setPreferredSize(new Dimension(_timeScaleSlider.getPreferredSize().width * 4, _timeScaleSlider
                .getPreferredSize().height));
        add(_timeScaleSlider);

        int initialSliderVal = (int)slidermax / 2;
        _timeScaleSlider.setValue(initialSliderVal);


        _timeScaleSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                _viewer.setSecondsDisplayed((int)Math.round(Math.pow(factor, _timeScaleSlider.getValue())), false);
            }
        });

        BoxTimeScaleRenderer btscr = new BoxTimeScaleRenderer();

        _viewer.setTimeScaleRenderer(btscr);
        if (_viewer.getGridRenderer() instanceof DefaultGridRenderer) {
            ((DefaultGridRenderer) _viewer.getGridRenderer()).setTickProvider(btscr);
        }

        _viewer.setStartDate(new JaretDate(0, 0, 0, 0, 0, 0));
        _viewer.setSecondsDisplayed((int)Math.round(Math.pow(factor, _timeScaleSlider.getValue())), false);
        _viewer.setMaxDate(new JaretDate(0, 0, 0, 0, (int)(slidermax * factor), 0));

        _viewer.getRegionRectEnable();
    }
}