using UnityEngine;
using System.Collections;
using UnityEngine.UI; // include UI namespace since references UI Buttons directly
using UnityEngine.EventSystems; // include EventSystems namespace so can set initial input for controller support
using UnityEngine.SceneManagement; // include so we can load new scenes

public class MainMenuManager : MonoBehaviour {

	// references to Submenus
	public GameObject _MainMenu;
	public GameObject _LevelsMenu;
	public GameObject _AboutMenu;
	public GameObject _CropAndSoilMenu;
	public GameObject _ResultMenu;

	// references to Button GameObjects
	public GameObject MenuDefaultButton;
	public GameObject AboutDefaultButton;
	public GameObject LevelSelectDefaultButton;
	public GameObject QuitButton;
	public GameObject CropAndSoilDefaultButton;
	public GameObject ResultDefaultButton;

	
	
	// init the menu
	void Awake()
	{
		
		ShowMenu("MainMenu");
	}

	
	// Show the proper menu
	public void ShowMenu(string name)
	{
		// turn all menus off
		_MainMenu.SetActive (false);
		_AboutMenu.SetActive(false);
		_LevelsMenu.SetActive(false);
		_CropAndSoilMenu.SetActive(false);
		_ResultMenu.SetActive(false);

		// turn on desired menu and set default selected button for controller input
		switch(name) {
		case "MainMenu":
			_MainMenu.SetActive (true);
			EventSystem.current.SetSelectedGameObject (MenuDefaultButton);
			
			break;
		case "LevelSelect":
			_LevelsMenu.SetActive(true);
			EventSystem.current.SetSelectedGameObject (LevelSelectDefaultButton);
			
			break;
		case "About":
			_AboutMenu.SetActive(true);
			EventSystem.current.SetSelectedGameObject (AboutDefaultButton);
			
			break;
		case "CropAndSoil":
			_CropAndSoilMenu.SetActive(true);
			EventSystem.current.SetSelectedGameObject(CropAndSoilDefaultButton);
			
			break;
		case "Result":
			_ResultMenu.SetActive(true);
			EventSystem.current.SetSelectedGameObject(ResultDefaultButton);
			break;
		}
	}

	
	// quit the game
	public void QuitGame()
	{
		Application.Quit ();
	}
}
