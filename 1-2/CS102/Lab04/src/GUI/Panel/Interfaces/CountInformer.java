package GUI.Panel.Interfaces;

/**
 * @(#)CountInformer.java
 * Interface which is designed to inform UI that count has changed
 *
 * @author Berke Gokmen
 * @date 2021/11/13
 */
public interface CountInformer {
  /**
   * Method to inform that count has been changed
   * thus counts needs to be recounted and ui needs to be updated
   */
  void countUpdated();
}
