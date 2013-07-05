SwingUiBuilder
==============

Helps build Swing UI faster.

. A work in progress, feel free to try it and if you find it useful add to it or provide a feedback.
. The builder does not have any external dependencies.
. No new layout managers. Any Java inbuilt layout manager can be used.
. Inclined towards the GridBagLayout but not limited to.
. This is more of an idea that helps solve the many problems that Swing UI developers are faced with.
  . If you have previously created a Swing application, you would know how much time it takes to build a decent UI from Scratch.
  . If you wanted a quick UI with less effort then this is intended for that purpose.
. Just to give a glimpse of what this can do for you,

SwingUiBuilder.getInstance(debug)
  .createFrame(new GridBagLayout())
    .addPanel(new GridBagConstraint(), new GridBagLayout())
      .addLabel("Label 0")
        .getParent()
      .addTextField("Label 0")
        .show();
      
        
  
