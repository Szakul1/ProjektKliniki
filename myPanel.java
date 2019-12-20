import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public class myPanel extends JPanel implements ActionListener
{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    JLabel chooseColumn;
    JLabel writeCondition;
    String[] names;
    List<JPanel> help;
    List<JComboBox<String>> columns;
    List<JTextField> condition;
    List<JButton> remove;
    JFrame frame;
    public myPanel(String[] names, JFrame frame)
    {
        this.names = names;
        this.frame= frame;
        help = new ArrayList<>();
        columns = new ArrayList<>();
        condition = new ArrayList<>();
        remove = new ArrayList<>();
        chooseColumn = new JLabel("Kolumna                       ");
        writeCondition = new JLabel("Warunek");
        
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        help.add(new JPanel());
        help.get(0).setLayout(new FlowLayout(FlowLayout.LEFT));
        help.get(0).add(chooseColumn);
        help.get(0).add(writeCondition);
        add(help.get(0));
        addCondition();
    }
    
    private void addCondition()
    {
        columns.add(new JComboBox<>(names));
        columns.get(columns.size()-1).addActionListener(this);
        condition.add(new JTextField(20));
        remove.add(new JButton("X"));
        remove.get(remove.size()-1).addActionListener(this);;
        help.add(new JPanel());
        help.get(help.size()-1).setLayout(new FlowLayout());
        help.get(help.size()-1).add(columns.get(columns.size()-1));
        help.get(help.size()-1).add(condition.get(condition.size()-1));
        help.get(help.size()-1).add(remove.get(remove.size()-1));
        add(help.get(help.size()-1));
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(!e.getActionCommand().equals("X"))
        {
            addCondition();
            frame.pack();
        }
        else
        {
            for(int i=0; i<remove.size() && remove.size()>1; i++)
            {
                if(e.getSource().equals(remove.get(i)))
                {
                    remove(help.get(i+1));
                    help.remove(i+1);
                    condition.remove(i);
                    columns.remove(i);
                    remove.remove(i);
                    frame.pack();
                }
            }
        }
    }

    private FlowLayout getFlowLayout(int maximumSize)
    {
        FlowLayout flowLayout = new FlowLayout()
        {
        /**
			 *
			 */
			private static final long serialVersionUID = 1L;

		@Override 
        public Dimension preferredLayoutSize(Container target)
        {
            Dimension dimension = super.preferredLayoutSize(target);
            dimension.width = Math.min(maximumSize, dimension.width);
            return dimension;
        }
        };
        flowLayout.setAlignment(FlowLayout.LEADING);
        return flowLayout;
    }
}
